object NoteService {
    val NoteList = mutableListOf<Notes>()
    val CommentsList = mutableListOf<Comments>()
    var last_id: Int = 0
    var last_idCom : Int= 0


    fun clear(){
        NoteList.clear()
        CommentsList.clear()
        last_id=0
        last_idCom = 0
    }

    fun addNote(note: Notes): Notes {
        NoteService.NoteList += note.copy(note_id = ++last_id)
        CommentsList.add(note.comments)
        return NoteList.last()
    }

    fun addComment(comments: Comments): Comments {
        NoteService.CommentsList += comments.copy(ID = ++last_idCom)
        return CommentsList.last()
    }

    fun deleteNote(note_id: Int): Boolean {
        for (item in NoteList) {
            if (note_id == item.note_id) {
                NoteList.remove(item)
                deleteComment(item.comments.ID)
                return true
            }
        }
        throw NotFoundIDExeption("заметка по данному ID не найдена")
    }

    fun deleteComment(comentId: Int): Boolean {
        for (item in CommentsList) {
            if (comentId == item.ID) {
                item.remoteDel = true
                return true
            }
        }
        throw NotFoundIDExeption("коментарий по  данному ID не найден")// throw выкинуть исключение
    }

    fun editNote(item:Notes):Boolean {
        for (i in NoteList) {
            if (item.note_id == i.note_id) {
                val index = NoteList.indexOf(i)
                NoteList[index] = item.copy()
                return true
            }
        }
        throw NotFoundIDExeption ("нет такой заметки $item")
    }

    fun editComment(comment_id: Int, comments: Comments): Comments {
        for ((index, comment) in CommentsList.withIndex()) {
            if ((comment.ID == comment_id) && (comment.remoteDel == false)) {
                CommentsList[index] = comments
return comments
            }
        }
        throw  NotFoundIDExeption("коментарий  по данному iD ненайден")
    }

    fun getNoteById(id: Int): Notes {
        for (item in NoteList) {
            if (item.note_id == id) {
                println(item)
                return item
            }
        }
        throw NotFoundIDExeption("Заметка по данному ID  не найдено ")
    }

    fun restore(commentId: Int): Boolean {
        for (item in CommentsList) {
            if (commentId == item.ID) {
                item.remoteDel = false

                return false
            }
        }
        throw NotFoundIDExeption("коментарий по данному ID не найден")
    }


    fun readComment():List<Comments> {
       val filtered =  CommentsList.filter {comments: Comments -> comments.remoteDel==false }
return  filtered
        }

}
fun main() {
  //  val note1 = Notes(1, comments = Comments(33))
    //val note2 = Notes(2, comments = Comments(39))
    //NoteService.addNote(note1)
   // NoteService.addNote(note2)
    //  println(NoteService.NoteList)
    // NoteService.addComment(comments = Comments(1, 23))
    //  NoteService.deleteNote(1)
//    NoteService.editNote(1 , note2)
    //println(NoteService.CommentsList)
    // println( NoteService.editComment(1,comments = Comments(99)))
//println(NoteService.CommentsList)
    //println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
//  println(  NoteService.getNoteById(2))

    //NoteService.deleteComment(33)
    //println(NoteService.CommentsList)
//println(NoteService.NoteList)
  //  NoteService.deleteNote(1)
   // println(NoteService.NoteList)
  //  println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
 //println( NoteService.readComment())

   //println( NoteService.editNote(note2))

    //NoteService.getNoteById(1)


}