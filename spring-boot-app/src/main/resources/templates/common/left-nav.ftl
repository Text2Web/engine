<nav class="col-md-2 d-none d-md-block bg-light sidebar">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">

            <#assign currentActive = "#" >
            <#if activeNav?has_content>
                <#assign currentActive = activeNav >
            </#if>

            <li class="nav-item">
                <a class="nav-link <#if currentActive == "dashboard" >active</#if>" href="/text2web-manage">
                    Dashboard
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link <#if currentActive == "descriptor-report" >active</#if>" href="/text2web-manage/descriptor-report">
                    Descriptor Report
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link <#if currentActive == "document-export" >active</#if>" href="/text2web-manage/document-export">
                    Export Document
                </a>
            </li>

<#--            <li class="nav-item">-->
<#--                <a class="nav-link <#if currentActive == "clear-html-vcs" >active</#if>" href="/text2web-manage/clear-html-vcs">-->
<#--                    Clean HTML VCS-->
<#--                </a>-->
<#--            </li>-->

<#--            <li class="nav-item">-->
<#--                <a class="nav-link <#if currentActive == "settings" >active</#if>" href="/text2web-manage/settings">-->
<#--                    Settings-->
<#--                </a>-->
<#--            </li>-->

        </ul>
    </div>
</nav>