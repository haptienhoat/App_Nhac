const express = require('express')
const router = express.Router()
const CasiController = require('../app/controllers/CasiController')

router.get('/home', CasiController.home)
router.post('/store', CasiController.store)
router.get('/', CasiController.index)
router.get('/search', CasiController.search)


module.exports = router;