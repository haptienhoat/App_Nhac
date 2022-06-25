const mongoose = require('mongoose')
const Schema = mongoose.Schema

const Tacgia = new Schema ({
    idtacgia: { type: String, maxlength: 255},
    tentacgia: { type: String, maxlength: 255},
    hinhtacgia: { type: String, maxlength: 255}
})

module.exports = mongoose.model('Tacgia', Tacgia)