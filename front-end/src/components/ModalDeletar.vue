<script>
import axios from 'axios';

export default {
    data() {
        return {
            isModalOpen: false,
            resultado: this.resultado
        };
    },
    props: ["resultado"],
    methods: {
        openModal() {
            this.isModalOpen = true;
        },
        closeModal() {
            this.isModalOpen = false;
        },
        async deletarItem() {
            try {
                const response = await axios.delete(`http://localhost:8080/noticias/${this.$route.params.id}`);
            } catch (error) {
                console.error(error);
            }
            this.closeModal()
            this.$router.push('/')
            alert('Noticia deletada com sucesso!')
        }
    }
};
</script>

<template>
    <span @click="openModal">Deletar noticia</span>

    <div v-if="isModalOpen" class="modal">
        <div class="modal-content">
            <h2>Tem certeza que deseja excluir essa noticia?</h2>
            <span>Titulo: {{ resultado.titulo }}</span>
            <span>Autor: {{ resultado.autor }}</span>
            <span>Data de publicação: {{ resultado.data.split('-').reverse().join('/') }}</span>
            <button @click="deletarItem">Confirmar</button>
            <button @click="closeModal">Cancelar</button>
        </div>
    </div>
</template>

<style>
span {
    min-width: 102px;
    display: block;
    font-size: 0.9rem;
}

.modal {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: rgba(0, 0, 0, 0.5);
}

.modal-content {
    width: 90%;
    background-color: #fff;
    padding: 20px;
    border-radius: 4px;
}

.modal-content h2 {
    color: #000;
    margin-bottom: 1rem;
}

.modal-content span {
    color: #000;
}

.modal-content button {
    display: block;
    width: 100px;
    margin: 1rem auto 0 auto;
    padding: 0.5rem;
}

@media screen and (min-width: 768px) {
    span {
        font-size: 1.2rem;
    }

    span:hover {
        cursor: pointer;
        text-decoration: underline;
    }

    .modal-content {
        width: 50%;
    }

    .modal-content h2 {
        font-size: 1.5rem;
    }

    .modal-content span:hover{
        cursor: default;
        text-decoration: none
    }

    button:hover {
        cursor: pointer;
    }
}
</style>
