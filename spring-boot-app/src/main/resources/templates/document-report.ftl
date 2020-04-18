<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document Report</title>
    <#include "common/common-header.ftl"/>
</head>
<body>

<#include "common/header.ftl" />

<div class="container-fluid">
    <div class="row">

        <#assign activeNav = "document-report">
        <#include "common/left-nav.ftl" />


        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                <h1 class="h2">Document Export Report</h1>
            </div>
            <#if reports?has_content>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Status</th>
                            <th>Path</th>
                            <th>Message</th>
                            <th>Trash</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tbody>
                        <#list reports as key, report>
                            <tr>
                                <td>${ report.status?default("") }</td>
                                <td>${ report.path?default("") }</td>
                                <td>${ report.message?default("") }</td>
                                <td>${ report.trashPath?default("") }</td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            <#else>
                <h3 class="h3 text-center">Reports not available</h3>
            </#if>

        </main>
    </div>
</div>

</body>
</html>