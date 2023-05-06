<#macro template>
    <!DOCTYPE html>
    <html lang="en">
<html>
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <style>
        * {
            box-sizing: border-box;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            border: 1px solid #e7e7e7;
            background-color: #f3f3f3;
            hight: 50px;
        }

        li {
            float: left;
        }

        li a {
            display: block;
            color: #666;
            text-align: center;
            /*padding: 14px 16px*/;
            padding: 4px 6px;
            text-decoration: none;
        }

        li a:hover:not(.active) {
            background-color: #ddd;
        }

        li a.active {
            color: white;
            background-color: #4CAF50;
        }


        li > ul {
            position: absolute;
            top: 35px;
            display: none;
        }

        /*Делаем скрытую часть видимой*/
        li:hover > ul {
            display: block;
            width: 150px; /*Задаем ширину выпадающего меню*/
        }

        li:hover > ul > li {
            float: none; /*Убираем горизонтальное позиционирование*/
        }


        .row::after {
            content: "";
            clear: both;
            display: block;
        }

        [class*="col-"] {
            /* float: left;*/
            padding: 15px;
        }

        /*html {
            font-family: "Lucida Sans", sans-serif;
        }*/

        /*.menu ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }
        .menu li {
            padding: 8px;
            margin-bottom: 7px;
            background-color: #33b5e5;
            color: #ffffff;
            box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
        }
        .menu li:hover {
            background-color: #0099cc;
        }*/


        /* For desktop: */


        /*      .col-3 {
                  width: 20%;
              }

              .col-6 {
                  width: 60%;
                  padding: 0;
              }*/
        .col-1 {
            width: 1024px;
            margin: 0 auto;
            padding: 0;
        }

        .col-2 {
            width: 40%;
            float: left;
        }

        .col-3 {
            width: 60%;
            float: left;
        }

        /*.ggg {width: 20; float: left; background-color: #666666;}*/

        @media only screen and (max-width: 768px) {
            /* For mobile phones: */
            [class*="col-"] {
                width: 100%;
            }

            li > ul {
                position: absolute;
                /*top: 67px;*/
                top: 35px;
                display: none;
            }
        }


    </style>
</head>
<body>
<!--<div class="container mt-4">-->


<div class="row">

    <#--<div class="col-3"></div>-->
    <div class="col-1">
        <div style="padding-left: initial">
            <ul>
                <li><a class="active" href="/">Home</a></li>

                <li><a href="#news">Расход</a>
                    <ul>
                        <li><a href="/pay">Платеж</a></li>
                        <li><a href="/pay/category">Категории</a></li>
                        <li><a href="/pay/category/vid">Вид категории</a></li>
                    </ul>
                </li>

                <li><a href="#">Доход</a>
                    <ul>
                        <li><a href="/profit">Доход</a></li>
                        <li><a href="/profit/category">Категория</a></li>
                        <li><a href="/profit/category/vid">Вид Категория</a></li>
                    </ul>
                </li>

                <li><a href="#">Лимиты</a>
                    <ul>
                        <li><a href="/limit">Лимиты</a></li>
                        <li><a href="/pay/period">Период лимита</a></li>
                    </ul>
                </li>

                <li><a href="#">Расчет</a>
                    <ul>
                        <li><a href="/months">По месяцам</a></li>
                        <li><a href="/year">Общий</a></li>
                    </ul>
                </li>

            </ul>
        </div>
        <div class="container mt-4">
            <#nested/>
        </div>

    </div>
    <#--    <div class="col-3"></div>-->
</div>
</body>
</html>
</#macro>