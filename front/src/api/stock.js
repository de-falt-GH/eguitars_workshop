export default {
    get(pageNumber, pageSize) {
        const categories = ['молодые', 'пожилые', 'суперпожилые']
        const names = ['сталь', 'металл', 'литий', 'камень', 'кость мамонта']

        let materials = []
        for (let i = 0; i < pageSize; i++) {
            materials.push({
                id: 100000 + getRandomInt(900000),
                category: categories[getRandomInt(categories.length)],
                name: names[getRandomInt(names.length)],
                amount: getRandomInt(100)
            })
        }
        return materials
    },
    add(order){
        console.log(order)
    },
    updateAmount(id, val)
    {
        console.log(id, val)
    }
}

function getRandomInt(max) {
    return Math.floor(Math.random() * max);
}