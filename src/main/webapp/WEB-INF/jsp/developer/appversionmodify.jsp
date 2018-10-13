<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="common/header.jsp" %>
<div class="right_col" role="main">
    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
                <div class="x_title">
                    <h2> 修改APP版本信息 <i class="fa fa-user"></i><small>测试用户001</small></h2>
                    <div class="clearfix"></div>
                </div>
                <div class="x_title">
                    <h2>历史版本列表</h2>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content1">
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
                                <c:forEach var="version" items="${appversionList}">
                                    <tr class="odd" role="row">
                                        <td>${version.softwareName}</td>
                                        <td>${version.versionNo}</td>
                                        <td>${version.versionSize}</td>
                                        <td>${version.publishStatusName}</td>
                                        <td>${version.apkFileName}</td>
                                        <td><fmt:formatDate value="${version.modifyDate}" pattern="yyyy-MM-dd"/> </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>

                            <div class="clearfix"></div>
                            <div class="x_title">
                                <h2>修改版本信息</h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li>
                                        <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content" style="display: block">
                                <br>
                                <form class="form-horizontal form-label-left" action="/dev/flatform/app/appversionToModify" method="post" enctype="multipart/form-data">
                                    <input type="hidden" id="id" name="id" value="${version.id}">
                                    <input type="hidden" id="appId" name="appId" value="${version.appId}">
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                            版本号
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="text" readonly="readonly" class="form-control" required placeholder="请输入版本号" name="versionNo" value="${version.versionNo}">
                                        </div>
                                    </div>
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                            版本大小
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="text" class="form-control" required placeholder="请输入版本号" name="versionSize" value="${version.versionSize}">
                                        </div>
                                    </div>
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                            发布状态
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            预发布
                                        </div>
                                    </div>
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                            版本简介
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="text" class="form-control" required placeholder="请输入版本号" name="versionInfo" value="${version.versionInfo}">
                                        </div>
                                    </div>
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">apk文件 <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="hidden" id="downloadLink" name="downloadLink" value="${version.downloadLink}"/>
                                            <input type="hidden" id="apkLocPath" name="apkLocPath" value="${version.apkLocPath}"/>
                                            <input type="hidden" id="apkFileName" name="apkFileName" value="${version.apkFileName}"/>
                                            <div id="uploadfile" style="display: none">
                                                <input id="attach" type="file" class="form-control col-md-7 col-xs-12" name="attach">
                                                <p><span style="color:red;font-weight: bold;">*注：1、大小不得超过500m.2、文件类型：apk</span></p>
                                            </div>
                                            <div id="apkFile"></div>
                                    </div>
                                    <div class="ln_solid"></div>
                                    <div class="form-group">
                                        <div class="col-md-6 col-md-offset-3">
                                            <button type="submit" class="btn btn-success">保存</button>
                                            <button type="submit" id="back" class="btn btn-primary">返回</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="common/footer.jsp" %>
<script src="${pageContext.request.contextPath}/statics/js/appversionmodify.js"></script>