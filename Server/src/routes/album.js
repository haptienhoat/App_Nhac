const express = require('express')
const router = express.Router()
const AlbumController = require('../app/controllers/AlbumController')

router.get('/home', AlbumController.home)
router.post('/store', AlbumController.store)
router.get('/', AlbumController.index)
router.get('/search', AlbumController.search)

module.exports = router;