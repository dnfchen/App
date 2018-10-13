<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="right_col" role="main">
    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
                <div class="x_title">
                    <h2> 修改APP基础信息
                        <i class="fa fa-user"></i>
                        <small>测试用户001</small>
                    </h2>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <form class="form-horizontal form-label-left" method="post" action="${pageContext.request.contextPath}/dev/flatform/app/modifyApp" enctype="multipart/form-data">
                        <input type="hidden" name="id" id="id" value="${appinfo.id}">
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                软件名称 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" name="softwareName" class="form-control col-md-7 col-xs-12"
                                       data-validate-length-range="20" data-validate-words="1" required
                                       placeholder="请输入软件名称" value="${appinfo.softwareName}">
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                APK名称 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 colAPKName-sm-6 col-xs-12">
                                <input type="text" name="" class="form-control col-md-7 col-xs-12"
                                       data-validate-length-range="20" data-validate-words="1" required
                                       placeholder="请输入APK名称" value="${appinfo.APKName}" readonly>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                支持ROM <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" name="supportROM" class="form-control col-md-7 col-xs-12"
                                       data-validate-length-range="20" data-validate-words="1" required
                                       placeholder="请输入支持的ROM" value="${appinfo.supportROM}">
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                界面语言 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" name="interfaceLanguage" class="form-control col-md-7 col-xs-12"
                                       data-validate-length-range="20" data-validate-words="1" required
                                       placeholder="请输入界面语言" value="${appinfo.interfaceLanguage}">
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                软件大小 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" name="softwareSize" class="form-control col-md-7 col-xs-12"
                                       data-validate-minmax="10,500" data-validate-words="1" required
                                       placeholder="请输入软件大小，单位为MB" value="${appinfo.softwareSize}">
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                下载次数 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" name="downloads" class="form-control col-md-7 col-xs-12"
                                       data-validate-length-range="20" data-validate-words="1" required
                                       placeholder="请输入下载次数" value="${appinfo.downloads}">
                            </div>
                        </div>

                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台 <span class="required">*</span></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="hidden" value="${appinfo.flatformId}" id="fid" />
                                <select name="flatformId" id="flatformId" class="form-control" required="required"></select>
                            </div>
                        </div>

                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类 <span class="required">*</span></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="hidden" value="${appinfo.categoryLevel1}" id="cl1" />
                                <select name="categoryLevel1" id="categoryLevel1" class="form-control"  required="required"></select>
                            </div>
                        </div>

                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类 <span class="required">*</span></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="hidden" value="${appinfo.categoryLevel2}" id="cl2" />
                                <select name="categoryLevel2" id="categoryLevel2" class="form-control"  required="required"></select>
                            </div>
                        </div>

                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类 <span class="required">*</span></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="hidden" value="${appinfo.categoryLevel3}" id="cl3" />
                                <select name="categoryLevel3" id="categoryLevel3" class="form-control"  required="required"></select>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                APP状态 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" name="statusName" class="form-control col-md-7 col-xs-12" value="${appinfo.statusName}" readonly>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                应用简介 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <textarea name="appInfo" required placeholder="请输入本软件的相关信息，本信息作为软件的详细信息进行软件的介绍。" class="form-control col-md-7 col-xs-12">${appinfo.appInfo}</textarea>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                LOGO图片 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="hidden" id="logoPicPath" name="logoPicPath" value="${appinfo.logoPicPath}"/>
                                <input type="hidden" id="logoLocPath" name="logoLocPath" value="${appinfo.logoLocPath}"/>
                                <div id="uploadfile" style="display: none">
                                    <input id="attach"  type="file" class="form-control col-md-7 col-xs-12" name="attach">
                                    <p><span style="color:red;font-weight: bold;">*注：1、大小不得超过500k.2、图片格式：jpg、png、jpeg、pneg</span></p>
                                </div>
                                <div id="logoFile"></div>
                                ${fileUploadError }
                            </div>
                        </div>
                        <div class="ln_solid"></div>
                        <div class="form-group">
                            <div class="ccol-md-6 col-md-offset-3">
                                <c:if test="${appinfo.status==3}">
                                    <button id="send" type="submit" name="status" value="1" class="btn btn-success">保存并再次提交审核</button>
                                </c:if>
                                <button type="submit" class="btn btn-success">保存</button>
                                <button type="button" class="btn btn-primary" id="back">返回</button>
                                <br>
                                <br>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

        </div>
    </div>

</div>
<%@include file="common/footer.jsp" %>
<script src="${pageContext.request.contextPath}/statics/js/appinfomodify.js"></script>
