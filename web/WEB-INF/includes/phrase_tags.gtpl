<h3>Štítky</h3>

<ul>
    <% cz.kibo.wordbook.constant.Constant.PHRASE_TAGS.each(){ key, value -> %>
        <li><a href="/fraze/tag/${key}">${value}</a></li>
    <%}%>
</ul>
