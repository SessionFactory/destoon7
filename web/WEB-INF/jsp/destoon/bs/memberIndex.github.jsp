<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class=" is-copy-enabled is-u2f-enabled">
<head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# object: http://ogp.me/ns/object# article: http://ogp.me/ns/article# profile: http://ogp.me/ns/profile#">
    <meta charset='utf-8'>
    <meta content="origin-when-cross-origin" name="referrer"/>
    <link crossorigin="anonymous" href="https://assets-cdn.github.com/assets/frameworks-92d354668263723b226099d22b6ff9945593c2bfe41f4403b91481b735f484b0.css" integrity="sha256-ktNUZoJjcjsiYJnSK2/5lFWTwr/kH0QDuRSBtzX0hLA=" media="all" rel="stylesheet"/>
    <link crossorigin="anonymous" href="https://assets-cdn.github.com/assets/github-7ec438ba7c15d1510c0d2b3bf1f8c7fcd0f7660c73590fa65e728a279787ca91.css" integrity="sha256-fsQ4unwV0VEMDSs78fjH/ND3ZgxzWQ+mXnKKJ5eHypE=" media="all" rel="stylesheet"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Language" content="en">
    <meta name="viewport" content="width=device-width">
    <title>会员主页</title>
</head>

<body class="logged-in  env-production windows  page-dashboard">
<div id="js-pjax-loader-bar" class="pjax-loader-bar">
    <div class="progress"></div>
</div>
<a href="#start-of-content" tabindex="1" class="accessibility-aid js-skip-to-content">Skip to content</a>
<div class="header header-logged-in true" role="banner">
    <div class="container clearfix">

        <a class="header-logo-invertocat" data-hotkey="g d" aria-label="Homepage" data-ga-click="Header, go to dashboard, icon:logo">
            <svg aria-hidden="true" class="octicon octicon-mark-github"
                 height="28" version="1.1" viewBox="0 0 16 16" width="28">
                <path fill-rule="evenodd"
                      d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27.68 0 1.36.09 2 .27 1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.013 8.013 0 0 0 16 8c0-4.42-3.58-8-8-8z"/>
            </svg>
        </a>

        <div class="header-search   js-site-search" role="search">
            <form accept-charset="UTF-8" class="js-site-search-form" data-unscoped-search-url="/search" method="get">
                <div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;"/></div>
                <label class="form-control header-search-wrapper js-chromeless-input-container">
                    <div class="header-search-scope"></div>
                    <input type="text"
                           class="form-control header-search-input js-site-search-focus "
                           data-hotkey="s"
                           name="q"
                           placeholder="搜索会员"
                           aria-label="Search GitHub"
                           data-unscoped-placeholder="Search GitHub"
                           data-scoped-placeholder="Search"
                           autocapitalize="off">
                </label>
            </form>
        </div>

        <ul class="header-nav user-nav float-right" id="user-links">
            <li class="header-nav-item">


            </li>

            <li class="header-nav-item dropdown js-menu-container">
                <a class="header-nav-link tooltipped tooltipped-s js-menu-target" href="/new"
                   aria-label="Create new…"
                   data-ga-click="Header, create new, icon:add">
                    <svg aria-hidden="true" class="octicon octicon-plus float-left" height="16" version="1.1" viewBox="0 0 12 16" width="12">
                        <path fill-rule="evenodd" d="M12 9H7v5H5V9H0V7h5V2h2v5h5z"/>
                    </svg>
                    <span class="dropdown-caret"></span>
                </a>

                <div class="dropdown-menu-content js-menu-content">
                    <ul class="dropdown-menu dropdown-menu-sw">
                        <a class="dropdown-item" data-ga-click="Header, create new repository">
                            新建会员
                        </a>

                        <a class="dropdown-item" data-ga-click="Header, create new organization">
                            修改会员信息
                        </a>
                    </ul>
                </div>
            </li>
            <li class="header-nav-item dropdown js-menu-container">
                <a class="header-nav-link name tooltipped tooltipped-sw js-menu-target" href="/SessionFactory"
                   aria-label="View profile and more"
                   data-ga-click="Header, show menu, icon:avatar">
                    <img alt="@SessionFactory" class="avatar" height="20" src="https://avatars2.githubusercontent.com/u/16712332?v=3&amp;s=40" width="20"/>
                    <span class="dropdown-caret"></span>
                </a>

                <div class="dropdown-menu-content js-menu-content">
                    <div class="dropdown-menu dropdown-menu-sw">
                        <div class="dropdown-header header-nav-current-user css-truncate">
                            Signed in as <strong class="css-truncate-target">SessionFactory</strong>
                        </div>

                        <div class="dropdown-divider"></div>

                        <a class="dropdown-item" data-ga-click="Header, go to profile, text:your profile">
                            查看你的会员信息
                        </a>
                        <a class="dropdown-item" data-ga-click="Header, go to starred repos, text:your stars">
                            删除会员信息
                        </a>
                        <a class="dropdown-item" data-ga-click="Header, go to explore, text:explore">
                            浏览会员信息
                        </a>
                        <a class="dropdown-item" data-ga-click="Header, go to help, text:help">
                            Help
                        </a>
                        </option>
                        </form>
                    </div>
                </div>
            </li>
        </ul>


    </div>
</div>


<div id="start-of-content" class="accessibility-aid"></div>

<div id="js-flash-container">
</div>


<div role="main">

    <div id="js-pjax-container" data-pjax-container>
        <div class="container page-content">
            <div id="dashboard" class="columns dashboard" data-ga-load="Dashboard, view, context:user">
                <div class="news column two-thirds">
                    <div class="select-menu account-switcher js-menu-container js-select-menu">
                        <button class="btn select-menu-button with-gravatar js-menu-target" aria-haspopup="true" aria-label="Switch account context" type="button" tabindex="0" data-ga-click="Dashboard, click, Opened account context switcher">
                            <div class="select-menu-button-gravatar js-select-button-gravatar">
                                <img alt="@SessionFactory" height="20" src="https://avatars2.githubusercontent.com/u/16712332?v=3&amp;s=40" width="20"/>
                            </div>
                            <span class="js-select-button css-truncate css-truncate-target">SessionFactory</span>
                        </button>

                        <div class="select-menu-modal-holder js-menu-content" role="menu" aria-labelledby="context-switch-title" aria-hidden="true">
                            <div class="select-menu-modal js-navigation-container">
                                <div class="select-menu-header js-navigation-enable" tabindex="-1">
                                    <svg aria-label="Close" class="octicon octicon-x js-menu-close" height="16" role="img" version="1.1" viewBox="0 0 12 16" width="12">
                                        <path fill-rule="evenodd" d="M7.48 8l3.75 3.75-1.48 1.48L6 9.48l-3.75 3.75-1.48-1.48L4.52 8 .77 4.25l1.48-1.48L6 6.52l3.75-3.75 1.48 1.48z"/>
                                    </svg>
                                    <span class="select-menu-title" id="context-switch-title">Switch dashboard context</span>
                                </div>


                                <div class="select-menu-list">
                                    <div data-filterable-for="context-context-filter-field" data-filterable-type="fuzzy">

                                        <!-- SessionFactory下拉框 -->
                                        <a href="/" role="menuitem" class="select-menu-item js-navigation-item js-navigation-open selected" data-ga-click="Dashboard, switch context, Switch dashboard context from:user to:user">
                                            <svg aria-hidden="true" class="octicon octicon-check select-menu-item-icon" height="16" version="1.1" viewBox="0 0 12 16" width="12">
                                                <path fill-rule="evenodd" d="M12 5l-8 8-4-4 1.5-1.5L4 10l6.5-6.5z"/>
                                            </svg>
                                            <div class="select-menu-item-gravatar">
                                                <img alt="@SessionFactory" height="20"
                                                     src="https://avatars2.githubusercontent.com/u/16712332?v=3&amp;s=40" width="20"/>
                                            </div>
<span class="select-menu-item-text">
  SessionFactory
</span>
                                        </a>
                                        <!-- SessionFactory下拉框 -->
                                    </div>
                                </div>

                                <div class="select-menu-list">
                                    <a href="/account/organizations" class="select-menu-item select-menu-action js-navigation-item js-navigation-open" data-ga-click="Dashboard, click, Manage orgs link in context switcher - context:user">
                                        <svg aria-hidden="true" class="octicon octicon-organization select-menu-item-icon" height="16" version="1.1" viewBox="0 0 16 16" width="16">
                                            <path fill-rule="evenodd" d="M16 12.999c0 .439-.45 1-1 1H7.995c-.539 0-.994-.447-.995-.999H1c-.54 0-1-.561-1-1 0-2.634 3-4 3-4s.229-.409 0-1c-.841-.621-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.442.58 2.5 3c.058 2.41-.159 2.379-1 3-.229.59 0 1 0 1s1.549.711 2.42 2.088C9.196 9.369 10 8.999 10 8.999s.229-.409 0-1c-.841-.62-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.437.581 2.495 3c.059 2.41-.158 2.38-1 3-.229.59 0 1 0 1s3.005 1.366 3.005 4"/>
                                        </svg>
                                        <span class="select-menu-item-text">Manage organizations</span>
                                    </a>
                                    <a href="/account/organizations/new" class="select-menu-item select-menu-action js-navigation-item js-navigation-open" data-ga-click="Dashboard, click, Create org link in context switcher - context:user first:false">
                                        <svg aria-hidden="true" class="octicon octicon-plus select-menu-item-icon" height="16" version="1.1" viewBox="0 0 12 16" width="12">
                                            <path fill-rule="evenodd" d="M12 9H7v5H5V9H0V7h5V2h2v5h5z"/>
                                        </svg>
                                        <span class="select-menu-item-text">Create organization</span>
                                    </a>
                                </div>


                            </div>
                        </div>
                    </div>

                    <!-- important -->
                    <%-- <div class="newsfeed-placeholder">
                         <img alt="Newsfeed-mini" class="newsfeed-placeholder-graphic" height="138" src="https://assets-cdn.github.com/images/modules/dashboard/newsfeed-mini.png" width="188"/>
                         <h3>Discover interesting projects and people to populate your personal news feed.</h3>
                         <p>
                             Your news feed helps you keep up with recent activity on repositories you <a href="/trending">watch</a> and people you <a href="/trending/developers">follow</a>.
                         </p>
                         <a href="/explore" class="btn btn-outline">Explore GitHub</a>
                     </div>--%>

                </div>

                <div class="dashboard-sidebar column one-third">

                    <div class="boxed-group js-repo-filter flush" role="navigation">
                        <h3>
                            Repositories you contribute to
     <span class="counter">
       7
     </span>
                        </h3>
                        <div class="boxed-group-inner">
                            <ul class="mini-repo-list js-repo-list">
                                <li class="public source ">
                                    <a href="/tongange/JavaEE8OA" class="mini-repo-list-item css-truncate"
                                       data-ga-click="Dashboard, click, Popular repos list item - context:user visibility:public fork:false">
                                        <svg aria-label="Repository" class="octicon octicon-repo repo-icon" height="16" role="img" version="1.1" viewBox="0 0 12 16" width="12">
                                            <path fill-rule="evenodd"
                                                  d="M4 9H3V8h1v1zm0-3H3v1h1V6zm0-2H3v1h1V4zm0-2H3v1h1V2zm8-1v12c0 .55-.45 1-1 1H6v2l-1.5-1.5L3 16v-2H1c-.55 0-1-.45-1-1V1c0-.55.45-1 1-1h10c.55 0 1 .45 1 1zm-1 10H1v2h2v-1h3v1h5v-2zm0-10H2v9h9V1z"/>
                                        </svg>
      <span class="repo-and-owner css-truncate-target">
        <span class="owner css-truncate-target" title="tongange">tongange</span>/<span class="repo" title="JavaEE8OA">JavaEE8OA</span>
      </span>
      <span class="stars">
        0
        <svg aria-label="stars" class="octicon octicon-star" height="16" role="img" version="1.1" viewBox="0 0 14 16" width="14">
            <path fill-rule="evenodd" d="M14 6l-4.9-.64L7 1 4.9 5.36 0 6l3.6 3.26L2.67 14 7 11.67 11.33 14l-.93-4.74z"/>
        </svg>
      </span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>

                </div><!-- /sidebar -->

            </div><!-- /#dashboard -->
        </div><!-- /.container -->

    </div>
    <div class="modal-backdrop js-touch-events"></div>
</div>

<div id="ajax-error-message" class="ajax-error-message flash flash-error">
    <svg aria-hidden="true" class="octicon octicon-alert" height="16" version="1.1" viewBox="0 0 16 16" width="16">
        <path fill-rule="evenodd" d="M8.865 1.52c-.18-.31-.51-.5-.87-.5s-.69.19-.87.5L.275 13.5c-.18.31-.18.69 0 1 .19.31.52.5.87.5h13.7c.36 0 .69-.19.86-.5.17-.31.18-.69.01-1L8.865 1.52zM8.995 13h-2v-2h2v2zm0-3h-2V6h2v4z"/>
    </svg>
    <button type="button" class="flash-close js-flash-close js-ajax-error-dismiss" aria-label="Dismiss error">
        <svg aria-hidden="true" class="octicon octicon-x" height="16" version="1.1" viewBox="0 0 12 16" width="12">
            <path fill-rule="evenodd" d="M7.48 8l3.75 3.75-1.48 1.48L6 9.48l-3.75 3.75-1.48-1.48L4.52 8 .77 4.25l1.48-1.48L6 6.52l3.75-3.75 1.48 1.48z"/>
        </svg>
    </button>
    You can't perform that action at this time.
</div>


<script crossorigin="anonymous" integrity="sha256-L6pkwljRgRS3AhH1UbNFhz3Er2ole9n67+U+Wg3jw+k=" src="https://assets-cdn.github.com/assets/frameworks-2faa64c258d18114b70211f551b345873dc4af6a257bd9faefe53e5a0de3c3e9.js"></script>
<script async="async" crossorigin="anonymous" integrity="sha256-QqfDmJPTSCvPUPMjHY4gY7JompCTpDBYKnp+XRfHuIY=" src="https://assets-cdn.github.com/assets/github-42a7c39893d3482bcf50f3231d8e2063b2689a9093a430582a7a7e5d17c7b886.js"></script>


<div class="js-stale-session-flash stale-session-flash flash flash-warn flash-banner d-none">
    <svg aria-hidden="true" class="octicon octicon-alert" height="16" version="1.1" viewBox="0 0 16 16" width="16">
        <path fill-rule="evenodd" d="M8.865 1.52c-.18-.31-.51-.5-.87-.5s-.69.19-.87.5L.275 13.5c-.18.31-.18.69 0 1 .19.31.52.5.87.5h13.7c.36 0 .69-.19.86-.5.17-.31.18-.69.01-1L8.865 1.52zM8.995 13h-2v-2h2v2zm0-3h-2V6h2v4z"/>
    </svg>
    <span class="signed-in-tab-flash">You signed in with another tab or window. <a href="">Reload</a> to refresh your session.</span>
    <span class="signed-out-tab-flash">You signed out in another tab or window. <a href="">Reload</a> to refresh your session.</span>
</div>
<div class="facebox" id="facebox" style="display:none;">
    <div class="facebox-popup">
        <div class="facebox-content" role="dialog" aria-labelledby="facebox-header" aria-describedby="facebox-description">
        </div>
        <button type="button" class="facebox-close js-facebox-close" aria-label="Close modal">
            <svg aria-hidden="true" class="octicon octicon-x" height="16" version="1.1" viewBox="0 0 12 16" width="12">
                <path fill-rule="evenodd" d="M7.48 8l3.75 3.75-1.48 1.48L6 9.48l-3.75 3.75-1.48-1.48L4.52 8 .77 4.25l1.48-1.48L6 6.52l3.75-3.75 1.48 1.48z"/>
            </svg>
        </button>
    </div>
</div>
</body>
</html>
