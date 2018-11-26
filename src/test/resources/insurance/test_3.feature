#language: ru

#Тест план, сценария №2 к 08.11
#1. Перейти по ссылке - https://www.raiffeisen.ru/
#2. Нажать кнопку – Выбор региона
#3. Выбрать – Владимир
#4. Проверить, что на главной странице регион Москва сменилась на Владимир
#5. Поскроллить к концу страницы
#6. Проверить, что в конце страницы есть ссылки – Качество обслуживания, Карьера в банке, Реквизиты, Противодействие коррупции

Функционал: Выбор региона

  Сценарий: Выбор региона и проверка ссылки
    * загружена страница "RegionPage"
    * выполнено нажатие на "Выбор региона"
    * выполнено нажатие на элемент "Регион" с текстом "Владимир"
    * значение поля "Выбор региона" равно "ВЛАДИМИР"
    * скролл до элемента "Footer"