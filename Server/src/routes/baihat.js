const express = require('express')
const router = express.Router()
const BaihatController = require('../app/controllers/BaihatController')

router.get('/home', BaihatController.home)
router.post('/store', BaihatController.store)
router.get('/', BaihatController.index)
router.get('/id', BaihatController.id)
router.get('/album', BaihatController.album)
router.get('/casi', BaihatController.casi)
router.get('/tacgia', BaihatController.tacgia)
router.get('/theloai', BaihatController.theloai)
router.get('/search', BaihatController.search)



module.exports = router;