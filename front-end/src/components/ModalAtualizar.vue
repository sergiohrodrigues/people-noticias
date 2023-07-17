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
    async atualizarItem(resultado) {
      const novoItem = {
        titulo: resultado.srcElement[0].value,
        conteudo: resultado.srcElement[1].value,
        autor: resultado.srcElement[2].value,
        data: resultado.srcElement[3].value
      }
      try {
        const response = await axios.put(`http://localhost:8080/noticias/${this.$route.params.id}`, novoItem);
      } catch (error) {
        console.error(error);
      }
      this.closeModal()
      this.$router.push('/')
      alert('Noticia atualizada com sucesso!')
    }
  }
};
</script>
<template>
  <span @click="openModal">Editar noticia</span>

  <div v-if="isModalOpen" class="modal">
    <div class="modal-content">
      <h2>Editar Noticia</h2>
      <form action="" @submit.prevent="atualizarItem">
        <input type="text" placeholder="Titulo" required :value="resultado.titulo" maxlength="50">
        <input type="text" placeholder="Conteudo com 254 caracteres" required maxlength="254" :value="resultado.conteudo">
        <input type="text" placeholder="Autor" required :value="resultado.autor">
        <input type="date" placeholder="Data de publicação" required :value="resultado.data">
        <button type="submit">Enviar</button>
      </form>
      <button @click="closeModal">Cancelar</button>
    </div>
  </div>
</template>

<style scoped>
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
}

.modal-content form {
  display: flex;
  flex-direction: column;
  padding: 2rem 0;
  gap: 0.5rem;
}

.modal-content form input {
  font-size: 0.8rem;
  padding: 0.5rem 0;
  outline: none;
}

.modal-content form button {
  width: 100px;
  margin: 0 auto;
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
    font-size: 2.5rem;
  }

  .modal-content form input {
    text-align: center;
    font-size: 0.8rem;
    padding: 0.5rem 0;
    outline: none;
  }

  button:hover {
    cursor: pointer;
  }
}
</style>
