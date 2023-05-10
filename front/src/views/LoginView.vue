<template>
    <div class="login">
        <h1 class="header">Гитарная мастерская</h1>
        <el-form :model="form" label-width="120px" class="login-form" label-position="top">
            <el-form-item label="Логин" class="login-form-el">
                <el-input v-model="form.login"/>
            </el-form-item>
            <el-form-item label="Пароль" class="login-form-el">
                <el-input v-model="form.password"/>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onEnter">Войти</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
// @ is an alias to /src

export default {
    name: 'HomeView',
    data() {
        return {
            form: {
                login: '',
                password: ''
            },
        }
    },
    methods: {
        onEnter() {
            this.$router.push({name: 'clients'})
        }
    }
}
</script>

<style scoped>

.login {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: start;

    height: 100vh;
}

.header {
    margin-top: 30vh;
    margin-bottom: 50px;
}

</style>