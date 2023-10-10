import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class NoteServiceTest {

    @Before
    fun clearBeforeTest()
    {
        NoteService.clear()
    }
    @Test
    fun addNote() {
        val service55= NoteService
        val note1 = Notes(1, comments = Comments(0))
        val note2 = Notes(2, comments = Comments(0))
        service55.addNote(note1)
        service55.addNote(note2)
        val result = service55.NoteList.get(0)
        assertEquals(1,result.note_id)
    }

    @Test
    fun addComment() {
        val comment1 = Comments(0,2)
        val comment2 = Comments(0,3)
        NoteService.addComment(comment1)
        NoteService.addComment(comment2)
        val result =NoteService.CommentsList.get(0)
        assertEquals(1,result.ID)
    }

    @Test
    fun deleteNote() {
        val service = NoteService
        val note1 =Notes(1, comments = Comments(1))
        val note2 =Notes(2, comments = Comments(2))
        service.addNote(note1)
        service.addNote(note2)
        val del = NoteService.deleteNote(2)
        println(del)
        assertEquals(true,del)
    }

    @Test
    fun deleteComment() {
        val service = NoteService
        val comments =Comments(1,2)
        val comments1 = Comments(2,3)
        service.addComment(comments)
        service.addComment(comments1)
        val result = NoteService.deleteComment(1)
        assertEquals(true,result)

    }

    @Test
    fun editNote() {
   val service1 = NoteService
    val note1 =Notes(1, comments = Comments(1))
    service1.addNote(note1)

    val editresult =service1.editNote(Notes(1, comments = Comments(1,2)))

assertEquals(true,editresult)
    }

    @Test
    fun editComment() {
    val service = NoteService
    val comments =Comments(0,22)
    val comments1 = Comments(0,9)
    service.addComment(comments)

    val result = NoteService.editComment(1, comments1)
    println(result)
    assertEquals(comments1,result)
    }

    @Test
    fun getNoteById() {
    val service1 = NoteService
    val note1 =Notes(1, comments = Comments(1))
    val note2 =Notes(2, comments = Comments(2))
    val note3 =Notes(3, comments = Comments(3))
    service1.addNote(note1)
    service1.addNote(note2)
    service1.addNote(note3)
    val editresult =service1.getNoteById(2)
        println(editresult)

    assertEquals(note2,editresult)
    }

    @Test
    fun restore() {
    val service = NoteService
    val comments =Comments(1,22)
    val comments1 = Comments(2,9)
    service.addComment(comments)

    val result = NoteService.restore(1)
    println(result)
    assertEquals(false,result)
    }

    @Test
    fun readComment() {
    val service = NoteService
    val comments =Comments(1,22)
    val comments1 = Comments(2,9)
    service.addComment(comments)
    service.addComment(comments1)
    val result = NoteService.readComment()
    assertEquals(NoteService.CommentsList,result)

    }
}