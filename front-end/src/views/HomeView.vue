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
                console.log(this.resultado.length)
            } catch (error) {
                console.error(error);
            }
        }
    },
};
</script>

<template>
    <main>
        <section>
            <h2>Noticias</h2>
            <ul v-if="resultado != null && resultado.length > 0">
                <li v-for="r in resultado" :key="r.id">
                    <h3 v-on:click="() => {
                        this.$router.push('/detalhes/' + r.id)
                    }">
                        {{ r.titulo }}
                    </h3>
                    <p>Data de publicação: <br /> {{ r.data.split('-').reverse().join('/') }}</p>
                </li>
            </ul>
            <h2 v-else>Sem noticias no momento.</h2>
        </section>
    </main>
</template>

<style scoped>
section {
    text-align: center;
    padding: 2rem 0;
}

h2 {
    font-size: 2rem;
    color: #fff;
    font-weight: 600;
}

ul {
    width: 90%;
    margin: 0 auto;
    padding: 2rem 0;
    list-style: none;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    gap: 1rem;
}

li {
    width: 90%;
    background-color: #fff;
    padding: 1rem;
    border-radius: 1rem;
}

li h3 {
    font-weight: 600;
    color: #000;
    margin-bottom: 1rem;
    text-decoration: underline;
}

li p {
    color: #000;
}

@media screen and (min-width: 768px) {
    h2 {
        font-size: 2.5rem;
    }

    ul {
        flex-direction: row;
    }

    li {
        display: flex;
        flex-direction: column;
        justify-content: space-around;
        width: 300px;
        height: 250px;
    }

    li h3 {
        font-size: 1.5rem;
        text-decoration: none;
    }

    li h3:hover {
        cursor: pointer;
        text-decoration: underline #000;
    }

    li p {
        font-size: 1.2rem;
    }
}</style>