# Checklist для Unit tests for CRUD operations

1.Create or Add
- add regular record (assertTrue)
- add exist record (assertFalse)
- add null record (assertFalse)
- checking add record when size is full (assertFalse)

2.Read or Find 
- read exist record (assertEquals)
- read null/not exist record (assertFalse)
  
3.Update
- checking for data updates (assertEquals or assertTrue, depends on data)

4.Delete/Remove
- remove regular record (assertTrue)
- remove not exist record (assertNull or assertFalse)
- remove null (assertFalse)