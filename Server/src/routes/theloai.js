const express = require('express')
const router = express.Router()
const TheloaiController = require('../app/controllers/TheloaiController')

router.get('/home', TheloaiController.home)
router.post('/store', TheloaiController.store)
router.get('/', TheloaiController.index)
router.get('/search', TheloaiController.search)


module.exports = router;