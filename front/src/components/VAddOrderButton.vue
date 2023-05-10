<template>
    <div>
        <el-button
                class="header-button"
                type="success" plain
                :icon="Plus"
                @click="showDialog"
        >
            Добавить заказ
        </el-button>
        <el-dialog
                width="35%"
                v-model="dialogVisible"
                title="Новый заказ"
        >
            <el-form :model="order" label-width="120px">
                <el-form-item label="id клиента:">
                    <el-input v-model="order.clientId" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="инструмент:">
                    <el-input v-model="order.instrument" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="описание:">
                    <el-input v-model="order.description" type="textarea"/>
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="hideDialog" type="danger" plain>
                        Отмена
                    </el-button>
                    <el-button type="success" @click="addOrder">
                       Добавить
                    </el-button>
                </span>
            </template>
        </el-dialog>
    </div>
</template>

<script>

import {Plus} from "@element-plus/icons-vue";
import orders from "@/api/orders";

export default {
    name: "VAddOrderButton",
    computed: {
        Plus() {
            return Plus
        }
    },
    data() {
        return {
            dialogVisible: false,
            order: {
                clientId: '',
                instrument: '',
                description: ''

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
        addOrder() {
            orders.add(this.order)
            this.dialogVisible = false
            this.order = {}
        }
    }
}
</script>