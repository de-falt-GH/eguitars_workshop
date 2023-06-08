import axios from "axios";
import {ref} from "vue";

export default {
    get(pageNumber, pageSize) {
        // const categories = ['молодые', 'пожилые', 'суперпожилые']
        // const names = ['сталь', 'металл', 'литий', 'камень', 'кость мамонта']

        let materials = ref([])
        // for (let i = 0; i < pageSize; i++) {
        //     materials.push({
        //         id: 100000 + getRandomInt(900000),
        //         category: categories[getRandomInt(categories.length)],
        //         name: names[getRandomInt(names.length)],
        //         amount: getRandomInt(100)
        //     })
        // }

        axios({
            method: 'get',
            url: 'http://localhost:8080/materials'
        })
            .then((response) => {
                for (let i=(pageNumber-1)*pageSize; i < Math.min(pageNumber*pageSize, response.data.length); i++) {
                    materials.value.push({
                        id: response.data[i].id,
                        category: response.data[i].category,
                        instrument: response.data[i].instrument,
                        amount: response.data[i].amount
                    })
                }
            })

        return materials
    },
    add(material){
        axios({
            method: 'post',
            url: 'http://localhost:8080/materials',
            data: {
                name: material.name,
                amount: material.amount,
                category: material.category
            }
        })
    },
    updateAmount(id, val)
    {
        axios({
            method: 'put',
            url: `http://localhost:8080/materials/{id}`,
            data: {
                amount: val
            }
        })
    }
}

// function getRandomInt(max) {
//     return Math.floor(Math.random() * max);
// }