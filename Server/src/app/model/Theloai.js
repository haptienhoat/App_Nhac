const mongoose = require('mongoose')
const Schema = mongoose.Schema

const Theloai = new Schema ({
    idtheloai: { type: String, maxlength: 255},
    tentheloai: { type: String, maxlength: 255},
    hinhtheloai: { type: String, maxlength: 255}
})

module.exports = mongoose.model('Theloai', Theloai)