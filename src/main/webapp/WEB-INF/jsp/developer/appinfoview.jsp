<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="common/header.jsp" %>
<div class="right_col" role="main">
    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
                <div class="x_title">
                    <h2> 新增APP基础信息
                        <i class="fa fa-user"></i>
                        <small>${userSession.devName}</small>
                    </h2>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content1">
                    <form class="form-horizontal form-label-left" method="post" action="">
                        <input type="hidden" name="id" id="id" value="">
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                软件名称 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" class="form-control col-md-7 col-xs-12"
                                       data-validate-length-range="20" data-validate-words="1" required
                                       placeholder="请输入软件名称" value="${appinfo.softwareName}" readonly>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                APK名称 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" class="form-control col-md-7 col-xs-12"
                                       data-validate-length-range="20" data-validate-words="1" required
                                       placeholder="请输入APK名称" value="${appinfo.APKName}" readonly>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                支持ROM <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" class="form-control col-md-7 col-xs-12"
                                       data-validate-length-range="20" data-validate-words="1" required
                                       placeholder="请输入支持的ROM" value="${appinfo.supportROM}" readonly>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                界面语言 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" class="form-control col-md-7 col-xs-12"
                                       data-validate-length-range="20" data-validate-words="1" required
                                       placeholder="请输入界面语言" value="${appinfo.interfaceLanguage}" readonly>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                软件大小 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" class="form-control col-md-7 col-xs-12"
                                       data-validate-minmax="10,500" data-validate-words="1" required
                                       placeholder="请输入软件大小，单位为MB" value="${appinfo.softwareSize}" readonly>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                下载次数 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" class="form-control col-md-7 col-xs-12"
                                       data-validate-length-range="20" data-validate-words="1" required
                                       placeholder="请输入下载次数" value="${appinfo.downloads}" readonly>
                            </div>
                        </div>

                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                所属平台 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" class="form-control col-md-7 col-xs-12"
                                       data-validate-length-range="20" data-validate-words="1" required
                                       placeholder="请输入下载次数" value="${appinfo.flatformName}" readonly>
                            </div>
                        </div>

                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                所属分类 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" class="form-control col-md-7 col-xs-12"
                                       data-validate-length-range="20" data-validate-words="1" required
                                       placeholder="请输入下载次数" value="${appinfo.categoryLevel1Name}--/--${appinfo.categoryLevel2Name}--/--${appinfo.categoryLevel3Name}" readonly>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                APP状态 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" class="form-control col-md-7 col-xs-12" value="${appinfo.statusName}" readonly>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                应用简介 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <textarea required placeholder="请输入本软件的相关信息，本信息作为软件的详细信息进行软件的介绍。" class="form-control col-md-7 col-xs-12" readonly>${appinfo.appInfo}</textarea>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                LOGO图片 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <c:choose>
                                    <c:when test="${appinfo.logoPicPath == null || appinfo.logoPicPath == ''}">
                                        暂无
                                    </c:when>
                                    <c:otherwise>
                                        <img src="${appinfo.logoPicPath }?m=1" width="100px;"/>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="clearfix"></div>
                <div class="x_title">
                    <h2>历史版本列表</h2>
                    <ul class="nav navbar-right panel_toolbox">
                        <li>
                            <a href="#" class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <div class="row">
                        <div class="col-sm-12">
                            <table class="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <th style="width: 70px">软件名称</th>
                                    <th style="width: 10px">版本号</th>
                                    <th style="width: 90px">版本大小(单位:M)</th>
                                    <th style="width: 50px">发布状态</th>
                                    <th style="width: 50px">APK文件下载</th>
                                    <th style="width: 50px">最新更新时间</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="ver" items="${version}">
                                    <tr class="odd" role="row">
                                        <td>${ver.softwareName}</td>
                                        <td>${ver.versionNo}</td>
                                        <td>${ver.versionSize}</td>
                                        <td>${ver.publishStatusName}</td>
                                        <td>${ver.apkFileName}</td>
                                        <td><fmt:formatDate value="${ver.modifyDate}" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-6 col-md-offset-3">
                        <button type="button" class="btn btn-primary" id="back">返回</button>
                    </div>
                </div>
                <div class="clearfix"></div>
                <br><br>
            </div>

        </div>
    </div>

</div>
<%@include file="common/footer.jsp" %>
<script src="${pageContext.request.contextPath}/statics/js/appinfoview.js"></script>
