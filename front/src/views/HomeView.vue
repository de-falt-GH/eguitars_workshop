<template>
    <div class="home">
        <el-container>
            <el-header class="header">
                <h1 class="header__title">Гитарная мастерская</h1>
                <div>
                    <el-button
                            v-for='button in menu'
                            :key="button.name"
                            :type='button.type'
                            :plain='isPlainButton(button.name)'
                            @click='$router.push({name: button.name})'
                    >
                        {{ button.text }}
                    </el-button>
                </div>
            </el-header>
            <el-main class="main">
                <router-view/>
            </el-main>
        </el-container>
    </div>
</template>

<script>
// @ is an alias to /src


export default {
    name: 'HomeView',
    data() {
        return {
            menu: [
                {
                    name: 'clients',
                    text: 'клиенты',
                    type: 'primary',
                },
                {
                    name: 'orders',
                    text: 'заказы',
                    type: 'primary',
                },
                {
                    name: 'stock',
                    text: 'склад',
                    type: 'primary',
                }
            ]
        }
    },

    methods: {
        setPrimaryMenuButton() {
            console.log(this.$route.name)
            for (let button in this.menu) {
                if (button.name === this.$route.name) {
                    button.plain = false
                }
            }
        },
        isPlainButton(name){
            return !(name == this.$route.name)
        }
    }
}
</script>

<style scoped>

.home {
    height: 100vh;
}

.header {
    height: 70px;
    border-bottom: 1px solid #636466;
    display: flex;
    flex-direction: row;
    align-items: center;
}

.main{
    height: calc(100vh - 70px);
}

.header__title {
    margin-right: 50px;
}

</style>
