<ol>
<li> Если в аппликации стоит задача хранить уникальные данные, то в первую очередь надо изучить вопрос использования сетов.
</li> 
<li> Если объекты какого-то типа решили хранить в HashSet, то желательно позаботиться, чтобы поля учавствующие в расчете hashCode были неизменными. Изменение соответствующих полей, может привести к "утечке" данных из сета.
</li>
<li> TreeSet Java реализован как <a href="https://habrahabr.ru/post/330644/">красно-черное дерево</a>. Вот <a href="https://www.cs.usfca.edu/~galles/visualization/RedBlack.html">Визуализация красно-черного дерева</a>.
</li>
<li> В TreeSet для определения уникальности хранимых данных, они должны быть или Comparable, или в TreeSet при создании должен быть передан Comparator.
</li>
</ol>