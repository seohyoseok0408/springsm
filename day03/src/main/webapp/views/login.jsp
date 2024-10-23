<%--
  Created by IntelliJ IDEA.
  User: hyoseokseo
  Date: 2024. 10. 8.
  Time: PM 1:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    let login = {
        init:function(){
            $('#login_form > button').click(()=>{
                this.check();
            });
        },
        check:function(){
            let id = $('#id').val();
            let pwd = $('#pwd').val();
            if(id == '' || id == null){
                alert('Id is Mandatory');
                $('#id').focus();
                return;
            }
            if(pwd == '' || pwd == null){
                alert('Pwd is Mandatory');
                $('#pwd').focus();
                return;
            }
            this.send();
        },
        send:function(){
            // method, action
            $('#login_form').attr('method','post');
            $('#login_form').attr('action','/loginimpl');
            $('#login_form').submit();
        }
    }
    $(function(){
        login.init();
    });
</script>
<div class="col-sm-10">
    <h2>Login Page</h2>
    <div class="row">
        <div class="col-sm-5">
            <form id="login_form">
                <div class="form-group">
                    <label for="id">Id:</label>
                    <input type="text" value="id44" class="form-control" placeholder="Enter id" id="id" name="id">
                </div>
                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="password" value="1234" class="form-control" placeholder="Enter password" id="pwd" name="pwd">
                </div>
                <button type="button" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>