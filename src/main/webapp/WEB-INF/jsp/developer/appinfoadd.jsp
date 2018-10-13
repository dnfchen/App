<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/header.jsp" %>
<div class="right_col" role="main">
    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
                <div class="x_title">
                    <h2> 新增APP基础信息
                        <i class="fa fa-user"></i>
                        <small>测试用户001</small>
                    </h2>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <form class="form-horizontal form-label-left" method="post" action="${pageContext.request.contextPath}/dev/flatform/app/addAPP" enctype="multipart/form-data">
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
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" id="APKName" name="APKName" class="form-control col-md-7 col-xs-12"
                                       data-validate-length-range="20" data-validate-words="1" required
                                       placeholder="请输入APK名称" value="${appinfo.APKName}">
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
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                所属平台 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <select id="flatformId" name="flatformId" class="form-control" required>

                                </select>
                            </div>
                        </div>

                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                一级分类 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="hidden" value="${appinfo.categoryLevel1}" id="cl1" />
                                <select id="categoryLevel1" name="categoryLevel1" class="form-control" required>

                                </select>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                二级分类 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="hidden" value="${appinfo.categoryLevel2}" id="cl2" />
                                <select id="categoryLevel2" name="categoryLevel2" class="form-control" required>

                                </select>
                            </div>
                        </div>

                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                三级分类 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="hidden" value="${appinfo.categoryLevel3}" id="cl3" />
                                <select id="categoryLevel3" name="categoryLevel3" class="form-control" required>

                                </select>
                            </div>
                        </div>

                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                APP状态 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                待审核
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                应用简介 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <textarea required placeholder="请输入本软件的相关信息，本信息作为软件的详细信息进行软件的介绍。" name="appInfo"
                                          class="form-control col-md-7 col-xs-12">${appinfo.appInfo}</textarea>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                LOGO图片 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="file" id="a_logoPicPath" name="a_logoPicPath" class="form-control col-md-7 col-xs-12" value="${appinfo.logoPicPath}" required>
                                ${fileUploadError }
                            </div>
                        </div>
                        <div class="ln_solid"></div>
                        <div class="form-group">
                            <div class="ccol-md-6 col-md-offset-3">
                                <button type="submit" class="btn btn-success">保存</button>
                                <button type="button" id="back" class="btn btn-primary">返回</button>
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
<script src="${pageContext.request.contextPath}/statics/js/appinfoadd.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/appinfomodify.js"></script>