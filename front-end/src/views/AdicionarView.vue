<script setup>
    import { ref } from 'vue'
    import axios from 'axios';

    const inputTitulo = ref()
    const inputConteudo = ref()
    const inputAutor = ref()
    const inputData = ref()

    function enviarNoticia() {
        const newData = {
        titulo: inputTitulo.value,
        conteudo: inputConteudo.value,
        autor: inputAutor.value,
        data: inputData.value
        };
        
        axios.post('http://localhost:8080/noticias', newData)
        .then(response => {
        })
        .catch(error => {
            console.error(error);
        });

        alert('Noticia criada com sucesso!')
        inputTitulo.value = ''
        inputConteudo.value = ''
        inputAutor.value = ''
        inputData.value = ''
    }
</script>

<template>
    <main>
        <h2>Adicionar News</h2>
        <form action="" @submit.prevent="enviarNoticia">
            <label for="titulo">
                <strong>Titulo:</strong>
                <input type="text" name="titulo" placeholder="Digite um titulo para a noticia" v-model="inputTitulo" required maxlength="50">
            </label>
            <label for="conteudo">
                <strong>Conteudo:</strong>
                <input type="text" name="conteudo" placeholder="Digite um conteudo com até 254 caracteres" v-model="inputConteudo" required maxlength="254">
            </label>
            <label for="autor">
                <strong>Autor:</strong>
                <input type="text" name="autor" placeholder="Autor da noticia" v-model="inputAutor" required>
            </label>
            <label for="data">
                <strong>Data da publicação:</strong>
                <input type="date" name="data" v-model="inputData" required>
            </label>
            <button type="submit">Enviar</button>
        </form>
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
        margin-bottom: 1rem;
    }
    form{
        width: 90%;
        margin: 0 auto;
        display: flex;
        flex-direction: column;
    }
    form label{
        font-size: 1.3rem;
        color: #fff;
        text-align: left;
    }
    form label strong{
        font-weight: 600;
    }
    input{
        width: 100%;
        min-width: 220px;
        margin: 0 auto 0.2rem auto;
        outline: none;
        padding: 0.5rem 1rem;
    }
    button{
        width: 100px;
        margin: 0.5rem auto 0 auto;
        padding: 0.5rem;
    }
    button:hover{
        cursor: pointer;
    }

    @media screen and (min-width: 768px){
        form{
            width: 50%;
        }
        form input{
            font-size: 1.2rem;
        }
    }
</style>