<template>
    <div>
        <img src="./people.png" alt="">
        <ul>
            <a href="https://www.instagram.com/people55.io/" target="_blank"><font-awesome-icon icon="fa-brands fa-instagram" /></a>
            <a href="https://www.linkedin.com/company/people55/" target="_blank"><font-awesome-icon icon="fa-brands fa-linkedin" /></a>
            <a href="https://www.facebook.com/people55.io" target="_blank"><font-awesome-icon icon="fa-brands fa-facebook" /></a>
        </ul>
    </div>
    <nav>
        <RouterLink to="/">Pagina Inicial</RouterLink>
        <RouterLink to="/adicionar">Adicionar Noticia</RouterLink>
        <!-- <RouterLink to="/editar-deletar">Editar e Deletar Noticia</RouterLink> -->
    </nav>
</template>

<style scoped>
    div{
        display: flex;
        justify-content: space-around;
        align-items: center;
        padding: 1rem 0;
    }
    img{
        width: 150px;
    }
    svg{
        color: #fff;
        font-size: 1.5rem;
    }
    ul{
        display: flex;
        list-style: none;
        gap: 0.6rem;
    }
    li{
        color: #fff;
    }
    nav{
        display: flex;
        justify-content: center;
        gap: 2rem;
        padding: 1rem 0;
        background:#894200;
    }
    a{
        text-decoration: none;
        font-size: 1rem;
        color: #fff;
    }
@media screen and (min-width: 768px){
    img{
        width: 250px;
    }
    svg:hover{
        cursor: pointer;
        color: #894200;
    }
    ul{
        gap: 1rem;
    }
    a{
        font-size: 1.2rem;
    }
    a:hover{
        cursor: pointer;
        text-decoration: underline;
    }
}
</style>