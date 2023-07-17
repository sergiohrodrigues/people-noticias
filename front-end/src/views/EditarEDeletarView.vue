<script>
    import axios from 'axios';

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
            const response = await axios.get('http://localhost:8080/noticias');
            this.resultado = response.data;
        } catch (error) {
            console.error(error);
        }
        }
    }
    };
</script>

<template>
    <main>
        <section>
            <h2>Editar e Deletar Noticias</h2>
            <ul>
                <li v-for="r in resultado" :key="r.id">
                    <h3>{{r.titulo}}</h3>
                    <p>{{r.data}}</p>
                    <font-awesome-icon icon="fa-solid fa-pen-to-square" />
                    <font-awesome-icon icon="fa-solid fa-trash" />
                </li>
            </ul>
        </section>
    </main>
</template>

<style scoped>
    section{
        text-align: center;
        padding: 2rem 0;
    }
    h2{
        font-size: 2rem;
        color: #fff;
        font-weight: 600;
    }
    ul{
        padding: 2rem 0;
        list-style: none;
        display: flex;
        justify-content: center;
        gap: 1rem;
    }
    li h3{
        color: #fff;
    }
    li p{
        color: #fff;
    }
    svg{
        color: #fff;
    }
</style>