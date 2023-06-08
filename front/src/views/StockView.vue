<template>
    <div class="stock-wrapper">
        <div class="stock">
            <header class="stock-header">
                <h2 class="header-title">Склад</h2>
                <v-order-materials-button class="header-button" @addOrder="addOrder"/>
            </header>
            <el-table :data="materials" stripe class="client-table" :key="materials.id">
                <el-table-column prop="id" label="id" align="left"/>
                <el-table-column prop="category" label="категория"/>
                <el-table-column prop="name" label="названия"/>
                <el-table-column label="количество">
                    <template #default="props">
                        <el-input-number v-model="props.row.amount" :min="0"
                                         @change="updateAmount($event, props.row.id)"/>
                    </template>
                </el-table-column>
            </el-table>
            <el-pagination
                    class="stock-pagination"
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

import stock from "@/api/stock";
import VOrderMaterialsButton from "@/components/VOrderMaterialsButton.vue";

export default {
    name: "StockView",
    components: {VOrderMaterialsButton},
    data() {
        return {
            page: {
                size: 20,
                total: 400,
              current: 1
            },
            materials: []
        }
    },
    methods: {
        updatePage(val) {
            this.materials = stock.get(val, this.page.size)
            this.page.current = val
        },
        updateAmount(val, id) {
            stock.updateAmount(id, val)
            setTimeout(()=> {
                  this.updatePage(this.page.current)
                }, 10
            )
        },
        addOrder(order){
          stock.add(order);
          setTimeout(()=> {
                this.updatePage(this.page.current)
              }, 10
          )
        }
    },
    created() {
        this.materials = stock.get(1, this.page.size)
    }
}
</script>

<style scoped>

.stock-wrapper {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
}

.stock-header {
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

.stock {
    width: 100%;
    max-width: 1800px;
    height: 100%;

    display: flex;
    flex-direction: column;
    align-items: center;
}

.stock-pagination {
    margin-top: 20px;
}

.client-table {
    flex-grow: 1;
}

.table-row {
    margin-left: 40px;
}
</style>