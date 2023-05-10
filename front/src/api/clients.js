export default {
    get(pageNumber, pageSize) {
        const generateOrders = () => {
            let orders = []
            for (let i = 0; i < getRandomInt(21); i++) {
                orders.push(10000 + getRandomInt(90000))
            }
            return orders
        }

        const telephones = ['+7(73)626-20-72', '+7(27)204-65-59', '+7(202)718-45-67', '+7(292)097-11-44', '+7(591)405-61-88', '+7(0725)006-92-10', '+7(82)368-86-99']
        const surnames = ['Овчинников', 'Борисов ', 'Савельев', 'Комаров', 'Крюков', 'Исаев', 'Мартынов']
        const names = ['Артур', 'Валентин', 'Павел', 'Фрол', 'Арсений', 'Гурий', 'Роман']
        const patronymics = ['Леонидович', 'Львович', 'Филиппович', 'Глебович', 'Альвианович', 'Данилович', 'Антонинович']

        let clients = []
        for (let i = 0; i < pageSize; i++) {
            clients.push({
                id: pageNumber * 100 + i,
                name: `${surnames[getRandomInt(surnames.length)]} ${names[getRandomInt(names.length)]} ${patronymics[getRandomInt(patronymics.length)]}`,
                telephone: telephones[getRandomInt(telephones.length)],
                orders: generateOrders()
            })
        }
        return clients
    },

    delete(id){
        console.log(id)
    },
    addClient(client){
        console.log(client)
    }

}

function getRandomInt(max) {
    return Math.floor(Math.random() * max);
}