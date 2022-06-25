const mongoose = require('mongoose')
const Schema = mongoose.Schema

const Album = new Schema ({
    idalbum: { type: String, maxlength: 255},
    tenalbum: { type: String, maxlength: 255},
    hinhalbum: { type: String, maxlength: 255},
    casi: { type: String , maxlength: 255}
})

module.exports = mongoose.model('Album', Album)