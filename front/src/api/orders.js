export default {
    get(pageNumber, pageSize) {
        const statuses = getStatuses()
        const instruments = ['гитара', 'барабан', 'флейта', 'труба']

        let orders = []
        for (let i = 0; i < pageSize; i++) {
            orders.push({
                id: pageNumber * 100 + i,
                clientId: 100000 + getRandomInt(900000),
                instrument: instruments[getRandomInt(instruments.length)],
                description: 'очень очень бобробное описание заказа',
                status: Object.create(statuses[getRandomInt(statuses.length)]),
                date: new Date(2023, getRandomInt(12), getRandomInt(25), getRandomInt(24), getRandomInt(60), 0)
            })
        }
        return orders
    },
    delete(id) {
        console.log(id)
    },
    add(order) {
        console.log(order)
    },
    getStatuses(){
        return getStatuses()
    },
    updateOption(id, newStatus) {
        console.log(id, newStatus)
    }
}

function getRandomInt(max) {
    return Math.floor(Math.random() * max);
}

function getStatuses(){
    return [
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