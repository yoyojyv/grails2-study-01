import com.gtunes.Album
import com.gtunes.Artist
import com.gtunes.Song
import com.gtunes.User

class BootStrap {

    def init = { servletContext ->

        environments {

            development {

            }

            test {

            }

        }

        // create sample data
        createSampleData()
    }

    /**
     * create sample user
     */
    private createSampleUserIfRequired() {

        if (!User.findByLogin("yoyojyv")) {
            println "Create sample user 'yoyojyv'."
            def user = new User(login: "yoyojyv", password: "123123", firstName: "Jaeyong", lastName: "Kim").save(failOnError: true)
        }

    }

    /**
     * create sample data
     */
    private createSampleData() {

        // create sample user
        createSampleUserIfRequired()


        def genres = [ 'Rock', 'Hiphop', 'RnB', 'Ballad' ]


        // creat artist
        def artist = new Artist(name: "sample artist").save(failOnError: true)

        (1..20).each { albumIndex ->

            def random = new Random()
            def randomGenreIndex = random.nextInt(genres.size())

            def genre = genres[randomGenreIndex]

            def album = new Album(title: "album title - ${albumIndex}", year: 2013, genre: genre )

            (1..10).each { songIndex ->

                def song = new Song(title: "title - ${songIndex}", genre: genre, year: 2013, trackNumber: songIndex + 1, duration: random.nextInt(4) + 1, artist: artist)
                album.addToSongs(song)
            }

            artist.addToAlbums(album)

        }
    }


    def destroy = {
    }
}
