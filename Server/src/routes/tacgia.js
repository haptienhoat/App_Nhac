const express = require('express')
const router = express.Router()
const TacgiaController = require('../app/controllers/TacgiaController')

router.get('/home', TacgiaController.home)
router.post('/store', TacgiaController.store)
router.get('/', TacgiaController.index)
router.get('/search', TacgiaController.search)


module.exports = router;