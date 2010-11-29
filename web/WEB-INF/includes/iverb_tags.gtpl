<h3>Tagy</h3>
<ul>
    <% cz.kibo.wordbook.constant.Constant.IVERB_TAGS.each(){ key, value -> %>
        <li><a href="/nepravidelna_slovesa/tag/${key}">${value}</a></li>
    <%}%>
</ul>
