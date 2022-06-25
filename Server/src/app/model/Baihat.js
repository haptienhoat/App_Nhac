const mongoose = require('mongoose')
const Schema = mongoose.Schema

const Baihat = new Schema ({
    idbaihat: { type: String, maxlength: 255},
    idalbum: { type: String, maxlength: 255},
    idtheloai: { type: String, maxlength: 255},
    tenbaihat: { type: String, maxlength: 255},
    hinhbaihat: { type: String, maxlength: 255},
    linkbaihat: { type: String, maxlength: 255},
    tacgia: { type: String, maxlength: 255},
    casi: { type: String , maxlength: 255}
})

module.exports = mongoose.model('Baihat', Baihat)