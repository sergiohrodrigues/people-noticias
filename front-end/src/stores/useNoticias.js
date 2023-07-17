import { defineStore } from 'pinia'
import { computed, ref } from 'vue'

export const useNoticias = defineStore('noticias', () => {

    //state
    const noticias = ref([]);

    //actions
    const adicionarNoticia = (noticia) => {
        noticias.value = noticias.value.filter(x => x.id !== noticia)
        noticias.value.push(noticia)
    }

    //getters
    const totalNoticias = computed(() => noticias.value.length)


    return {
        adicionarNoticia,
        totalNoticias,
        noticias
    }
})