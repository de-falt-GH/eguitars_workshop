<template>
    <div>
        <el-button
                class="header-button"
                type="success" plain
                :icon="Plus"
                @click="showDialog"
        >
            Добавить клиента
        </el-button>
        <el-dialog
                width="35%"
                v-model="dialogVisible"
                title="Новый клиент"
        >
            <el-form :model="client" label-width="120px">
                <el-form-item label="ФИО:">
                    <el-input v-model="client.name" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="Телефон:">
                    <el-input v-model="client.telephone" autocomplete="off"/>
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="hideDialog" type="danger" plain>
                        Отмена
                    </el-button>
                    <el-button type="success" @click="addClient">
                       Добавить
                    </el-button>
                </span>
            </template>
        </el-dialog>
    </div>
</template>

<script>

import {Plus} from "@element-plus/icons-vue";
import clients from "@/api/clients";

export default {
    name: "VAddClientButton",
    computed: {
        Plus() {
            return Plus
        }
    },
    data() {
        return {
            dialogVisible: false,
            client:{
                name: '',
                telephone: '',

            }
        }
    },
    methods: {
        showDialog() {
            this.dialogVisible = true
        },
        hideDialog() {
            this.dialogVisible = false
        },
        addClient() {
            clients.addClient(this.client)
            this.dialogVisible = false
            this.client = {}
        }
    }
}
</script>