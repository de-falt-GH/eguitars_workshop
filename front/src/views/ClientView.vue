<template>
    <div class="client-wrapper">
        <div class="client">
            <header class="client-header">
                <h2 class="header-title">Список клиентов</h2>
                <v-add-client-button class="header-button" @addClient="addClient"/>
            </header>
            <el-table :data="clients" stripe class="client-table">
                <el-table-column type="expand">
                    <template #default="props">
                        <p class="table-row">{{ getOrderList(props.row) }}</p>
                    </template>
                </el-table-column>
                <el-table-column prop="id" label="id" align="left"/>
                <el-table-column prop="name" label="ФИО"/>
                <el-table-column prop="telephone" label="телефон"/>
                <el-table-column label="последний заказ">
                    <template #default="scope">
                        <p>{{ getOneOrder(scope.row) }}</p>
                    </template>
                </el-table-column>
                <el-table-column label="операции" align="center" width="100px">
                    <template #default="scope">
                        <el-button
                                size="small"
                                :icon="Delete"
                                type="danger"
                                @click="deleteClient(scope.row)"
                        >
                            Удалить
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>
            <el-pagination
                    class="client-pagination"
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

import clients from "@/api/clients";
import VAddClientButton from "@/components/VAddClinetButton.vue";
import {Delete} from "@element-plus/icons-vue";

export default {
    name: "ClientView",
    computed: {
        Delete() {
            return Delete
        }
    },
    components: {VAddClientButton},
    data() {
        return {
            page: {
                size: 20,
                total: 400,
                current: 1
            },
            clients: []
        }
    },
    methods: {
        updatePage(val) {
            this.clients = clients.get(val, this.page.size)
            this.page.current = val
        },
        deleteClient(row) {
            clients.delete(row.id)
            setTimeout(()=> {
              this.updatePage(this.page.current)
            }, 10
            )
        },
        getOneOrder(row) {
            return row.orders[0] ?? 'Нет заказов'
        },
        getOrderList(row) {
            if (row.orders.length === 0) {
                return 'Нет заказов'
            }
            return `Заказы: ${row.orders.join(', ')}`
        },

        addClient(client) {
          clients.addClient(client)
          setTimeout(()=> {
                this.updatePage(this.page.current)
              }, 10
          )
        }
    },
    created() {
        this.clients = clients.get(1, this.page.size)

    }
}
</script>

<style scoped>

.client-wrapper {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
}

.client-header {
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

.client {
    width: 100%;
    max-width: 1800px;
    height: 100%;

    display: flex;
    flex-direction: column;
    align-items: center;
}

.client-pagination {
    margin-top: 20px;
}

.client-table {
    flex-grow: 1;
}

.table-row {
    margin-left: 40px;
}
</style>