const mongoose = require('mongoose')
const Schema = mongoose.Schema

const Casi = new Schema ({
    idcasi: { type: String, maxlength: 255},
    tencasi: { type: String, maxlength: 255},
    hinhcasi: { type: String, maxlength: 255}
})

module.exports = mongoose.model('Casi', Casi)