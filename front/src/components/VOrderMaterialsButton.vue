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
                title="Новый заказ материалов"
        >
            <el-form :model="material" label-width="120px">
                <el-form-item label="категория">
                    <el-input v-model="material.category" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="название:">
                    <el-input v-model="material.name" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="количество">
                    <el-input-number v-model="material.amount" :min="1"/>
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="hideDialog" type="danger" plain>
                        Отмена
                    </el-button>
                    <el-button type="success" @click="addOrder">
                       Заказать
                    </el-button>
                </span>
            </template>
        </el-dialog>
    </div>
</template>

<script>

import {Plus} from "@element-plus/icons-vue";

export default {
    name: "VOrderMaterialsButton",
    computed: {
        Plus() {
            return Plus
        }
    },
    data() {
        return {
            dialogVisible: false,
            material: {
                category: '',
                name: '',
                amount: 1

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
            this.$emit('addOrder', this.material)
            this.dialogVisible = false
            this.order = {}
        }
    }
}
</script>