 <form action="/slovicka/slovnik/hledej" method="post">
   <fieldset class="corner">
        <legend class="corner">Vyhledávání</legend>
        <p>
            <label>Slovo</label>
            <input name="q" class="getFocus searchBox corner" type="text" maxlength="30" autocomplete="off" />

            <label><input type="radio" name="lang" value="en" checked="checked" />en</label>
            <label><input type="radio" name="lang" value="cs" />cs</label>
    
        </p>
    </fieldset>
    <div class="right">
        <input class="button" type="submit" value="Hledej ve slovníku" />
    </div>
</form>