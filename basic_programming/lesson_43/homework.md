# Task

* Создать класс Article (статья = название, содержание, имя автора, состояние), предусмотреть для него состояния:

```
DRAFT - черновик
ON_REVIEW - на проверке
PUBLISHED - опубликован
DECLINED - не разрешено к публикации
DELETED - статья удалена
ON_EDIT - на редактировании

DRAFT -> sendToReview() -> ON_REVIEW -> publish() -> PUBLISHED
                                        decline() -> DECLINED
DECLINED -> delete() ->  DELETED,
         -> edit()   ->  ON_EDIT
         
ON_EDIT -> delete() ->     DELETED,
           sendToReview -> ON_REVIEW
```

* Попробуйте написать UNIT-тест
* Мне в слак скидываете два файла - Article.java, TestArticle.java