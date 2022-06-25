const homeRouter = require('./home')
const baihatRouter = require('./baihat')
const casiRouter = require('./casi')
const albumRouter = require('./album')
const theloaiRouter = require('./theloai')
const tacgiaRouter = require('./tacgia')

function route(app) {
    app.use('/', homeRouter)
    app.use('/baihat', baihatRouter)
    app.use('/casi', casiRouter)
    app.use('/theloai', theloaiRouter)
    app.use('/tacgia', tacgiaRouter)
    app.use('/album', albumRouter)
}

module.exports = route;