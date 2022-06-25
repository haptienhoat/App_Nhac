const Album = require('../model/Album')

class AlbumController {
    index(req, res) {
        Album.find({}, function (err, album) {
            if (!err) res.json(album)
            else res.status(400).json({ error: 'error' })
        })
    }

    home(req, res) {
        res.render('album/home')
    }

    store(req, res, next) {
        const album = new Album(req.body)
        album.save()
            .then(() => res.redirect('/album/home'))
    }

    search(req, res) {
        Album.find({tenalbum: {'$regex': req.query.tukhoa}}, function(err, album) {
            if (!err) res.json(album)
            else res.status(400).json({error: 'error'})
        }) 
    }
}

module.exports = new AlbumController;