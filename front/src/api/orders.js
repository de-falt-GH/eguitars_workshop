import axios from "axios";
import {ref} from "vue";

export default {
    get(pageNumber, pageSize) {
        // const statuses = getStatuses()
        // const instruments = ['гитара', 'барабан', 'флейта', 'труба']

        let orders = ref([])
        // for (let i = 0; i < pageSize; i++) {
        //     orders.push({
        //         id: pageNumber * 100 + i,
        //         clientId: 100000 + getRandomInt(900000),
        //         instrument: instruments[getRandomInt(instruments.length)],
        //         description: 'очень очень бобробное описание заказа',
        //         status: Object.create(statuses[getRandomInt(statuses.length)]),
        //         date: new Date(2023, getRandomInt(12), getRandomInt(25), getRandomInt(24), getRandomInt(60), 0)
        //     })
        // }

        axios({
            method: 'get',
            url: 'http://localhost:8080/orders'
        })
            .then((response) => {
                for (let i=(pageNumber-1)*pageSize; i < Math.min(pageNumber*pageSize, response.data.length); i++) {
                    orders.value.push({
                        id: response.data[i].id,
                        instrument: response.data[i].instrument,
                        description: response.data[i].description,
                        status: {
                            value: response.data[i].status,
                            label: response.data[i].status
                        },
                        date: response.data[i].date
                    })
                }
            })

        return orders
    },
    delete(id) {
        axios({
            method: 'delete',
            url: `http://localhost:8080/orders/${id}`
        });
    },
    add(order) {
        axios({
            method: 'post',
            url: 'http://localhost:8080/orders',
            data: {
                instrument: order.instrument,
                client_id: order.clientId,
                description: order.description
            }
        })
    },
    getStatuses(){
        return getStatuses()
    },
    updateOption(id, newStatus) {
        console.log(id, newStatus)
    }
}

// function getRandomInt(max) {
//     return Math.floor(Math.random() * max);
// }

function getStatuses(){
    return [
        {
            value: 'accepted',
            label: 'принят'
        },

        {
            value: 'work',
            label: 'в работе'
        },
        {
            value: 'confirmed',
            label: 'подтвержден'
        },
        {
            value: 'done',
            label: 'готов'
        }

    ]
}