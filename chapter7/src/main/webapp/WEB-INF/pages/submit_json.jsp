<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>问卷调查</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
</head>
<body>
    <h2>问卷调查</h2>
    <table>
        <tr>
            <td>年龄：</td>
            <td><input type="text" name="age" id="age"></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td><input type="text" name="gender" id="gender"></td>
        </tr>
        <tr>
            <td>爱好：</td>
            <td>
                <input type="checkbox" name="hobbies" value="阅读">阅读<br>
                <input type="checkbox" name="hobbies" value="电影">电影<br>
                <input type="checkbox" name="hobbies" value="运动">运动<br>
            </td>
        </tr>
        <tr>
            <td><input type="button" value="提交" onclick="submit()"></td>
        </tr>
    </table>
    <script type="text/javascript">
        function submit() {
            var age = $("#age").val();
            var gender = $("#gender").val();
            var hobbies = document.getElementsByName("hobbies");
            var hobbyChecked = [];
            for (k in hobbies) {
                if (hobbies[k].checked)
                    hobbyChecked.push(hobbies[k].value);
            }
            $.ajax({
                url: "${pageContext.request.contextPath}/bind3/getParams",
                type: "post",
                data: JSON.stringify({age: age, gender: gender, hobbies: hobbyChecked}),
                contentType: "application/json;charset=UTF-8",
                dataType: "json",
            });
        }
    </script>
</body>
</html>