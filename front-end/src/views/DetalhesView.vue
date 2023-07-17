<script>
import axios from 'axios';
import ModalAtualizar from '../components/ModalAtualizar.vue';
import ModalDeletar from '../components/ModalDeletar.vue';

    export default {
    data() {
        return {
            resultado: null
        };
    },
    mounted() {
        this.chamarAPI();
    },
    methods: {
        async chamarAPI() {
            try {
                const response = await axios.get(`http://localhost:8080/noticias/${this.$route.params.id}`);
                this.resultado = response.data;
            }
            catch (error) {
                console.error(error);
            }
        }
    },
    components: { ModalAtualizar, ModalDeletar }
};
</script>

<template>
    <main>
        <div v-if="resultado !== null">
            <h2>{{resultado.titulo}}</h2>
            <p><strong>Descrição:</strong><br/> {{resultado.conteudo}}</p>
            <p><strong>Autor:</strong> <br/>{{resultado.autor}}</p>
            <span><strong>Data de publicação:</strong> <br/>{{resultado.data.split('-').reverse().join('/')}}</span>
            <div class="editAndDelete">
                <ModalAtualizar :resultado="resultado"/>
                <ModalDeletar :resultado="resultado"/>
            </div>
        </div>
    </main>
</template>

<style scoped>
    main{
        text-align: center;
        padding: 2rem 0;
    }
    h2{
        font-size: 2rem;
        font-weight: 600;
        color: #fff;
    }
    div{
        width: 90%;
        margin: 0 auto;
        color: #fff;
        display: flex;
        flex-direction: column;
        gap: 2rem;
    }
    strong{
        font-weight: 600;
        font-size: 1.3rem;
    }
    .editAndDelete{
        display: flex;
        flex-direction: row;
        justify-content: center;
        text-decoration: underline;
        margin-top: 3rem;
    }

    @media screen and (min-width: 768px){
        h2{
            font-size: 2.5rem;
        }
        div{
            width: 100%;
            padding: 0 5rem;
        }
        strong{
            font-size: 1.7rem;
        }
        p{
            font-size: 1.2rem;
        }
        span{
            font-size: 1.2rem;
        }
        span:hover{
            cursor: default;
            text-decoration: none;
        }
        .editAndDelete{
            text-decoration: none;
        }
    }
</style>