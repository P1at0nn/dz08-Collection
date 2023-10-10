interface MetodsforService<E> {
    fun add(item :E):Long       //создает новый элемент типа

    fun delete(id:Int)    // удаляет элеммент  по id

    fun edit(item:E)    // редактирует элемент

    fun read():List<E>     // прочитать весь список

    fun getById(id:Int):E   // возвращает  элемент Е по ID

    fun restore(id:Int)    // восстанавливает  удаленный элемент по id
}