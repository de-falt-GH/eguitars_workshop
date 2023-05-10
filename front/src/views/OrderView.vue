<template>
    <div class="order-wrapper">
        <div class="order">
            <header class="order-header">
                <h2 class="header-title">Список заказов</h2>
                <v-add-order-button class="header-button"/>
            </header>
            <el-table :data="orders" stripe class="order-table">
                <el-table-column type="expand">
                    <template #default="props">
                        <div class="row-description">
                            <h3>Описание:</h3>
                            <p>{{ getDescription(props.row) }}</p>
                        </div>
                    </template>
                </el-table-column>
                <el-table-column prop="id" label="id" align="left"/>
                <el-table-column prop="clientId" label="id клиента"/>
                <el-table-column prop="instrument" label="Инструмент"/>
                <el-table-column label="Статус">
                    <template #default="props">
                        <el-cascader v-model="props.row.status.value" :options="statusOption" @change="updateOption($event, props.row.id)"/>
                    </template>
                </el-table-column>
                <el-table-column label="Дата создания">
                    <template #default="props">
                        <span>{{ getDate(props.row) }}</span>
                    </template>
                </el-table-column>
                <el-table-column label="операции" align="center" width="240px">
                    <template #default="scope">
                        <el-button
                                size="small"
                                :icon="Delete"
                                type="danger"
                                @click="deleteOrder(scope.row)"
                        >
                            Удалить
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>
            <el-pagination
                    class="order-pagination"
                    @update:current-page="updatePage"
                    :page-size="page.size"
                    :pager-count="11"
                    layout="prev, pager, next"
                    :total="page.total"
            />
        </div>
    </div>
</template>

<script>
import orders from "@/api/orders";
import VAddOrderButton from "@/components/VAddOrderButton.vue";
import {Delete} from "@element-plus/icons-vue";

export default {
    name: "OrderView",
    computed: {
        Delete() {
            return Delete
        }
    },
    components: {VAddOrderButton},
    data() {
        return {
            page: {
                size: 20,
                total: 400
            },
            orders: [],
            statusOption: []
        }
    },
    methods: {
        updatePage(val) {
            this.orders = orders.get(val, this.page.size)
        },
        getDescription(row) {
            return row.description
        },
        getDate(row) {
            return row.date.toLocaleString()
        },
        deleteOrder(row) {
            orders.delete(row.id)
        },
        updateOption(newStatus, id){
            orders.updateOption(id, newStatus)
        }
    },
    created() {
        this.orders = orders.get(1, this.page.size)
        this.statusOption = orders.getStatuses()
    }
}
</script>

<style scoped>

.order-wrapper {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
}

.order-header {
    margin: 20px 0;
    width: 100%;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
}

.header-title {
    margin-left: auto;
}

.header-button {
    margin-left: auto;
}

.order {
    width: 100%;
    max-width: 1800px;
    height: 100%;

    display: flex;
    flex-direction: column;
    align-items: center;
}

.order-pagination {
    margin-top: 20px;
}

.order-table {
    flex-grow: 1;
}

.row-description {
    margin-left: 40px;
}
</style>